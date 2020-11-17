#!/usr/bin/env  python
# -*- coding:utf-8 -*-

# @Create_time     :2020/10/19 15:15
# @Author          :wuweihong6
# @e-mail          :1454565178@qq.com
# @File            :multitask.py
# @software        :PyCharm
# @description     :

from threading import Thread, Semaphore
import socket

NTHREADS = 4
BUFSIZE = 16

class Sbuf:
    buf = None
    n = 0
    mutex = 0
    slots = 0
    items = 0

    def __init__(self, n):
        self.buf = []
        self.n = n
        self.mutex = Semaphore(1)
        self.slots = Semaphore(n)
        self.items = Semaphore(0)

    def sbuf_insert(self, item):
        self.slots.acquire()
        self.mutex.acquire()
        self.buf.append(item)
        self.mutex.release()
        self.items.release()

    def sbuf_remove(self):
        self.items.acquire()
        self.mutex.acquire()
        item = self.buf.pop()
        self.mutex.release()
        self.slots.release()
        return item


sbuf = Sbuf(BUFSIZE)


def echo_cnt(conn, addr):
    msg = conn.recv(20)
    print("server received client:(%s, %s)" %addr)
    print(msg)


def task():
    print("hello")
    while True:
        conn, addr = sbuf.sbuf_remove()
        echo_cnt(conn, addr)
        conn.close()



def main():
    listenfd = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    listenfd.bind(("localhost", 8080))
    listenfd.listen(5)
    print("server is working...")
    for i in range(NTHREADS):
        t = Thread(name="t" + str(i), target=task)
        t.start()
    while True:
        conn, addr = listenfd.accept()
        sbuf.sbuf_insert((conn, addr))


if __name__=="__main__":
    main()
