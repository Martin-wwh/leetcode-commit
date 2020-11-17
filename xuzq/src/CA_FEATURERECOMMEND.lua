--
-- Created by IntelliJ IDEA.
-- User: xuzq11
-- Date: 2020-9-17
-- Time: 8:57
-- To change this template use File | Settings | File Templates.
--冰箱

local JSON = require "cjson"

local skills = {}
skills["fitStore"] = "小提示：如果有食材不清楚能不能放在冰箱里，问我就行"
skills["whereStore"] = "小提示：有些食材不清楚应该放冷藏还是冷冻时，可以问我"
skills["timeStore"] = "小提示：有些食材不清楚放冰箱多久合适时，问我就行"

function featureRecommend(reqJson)
    local devicePersistentData = reqJson["devicePersistentData"]
    local nowTime = os.time()
    local unreachableSkills = {}
    --找到在冷却期的技能，此次不推送相关NLG
    for k,v in pairs(devicePersistentData) do
        local _, _, y, m, d, _hour, _min, _sec = string.find(v, "(%d+)/(%d+)/(%d+)%s*(%d+):(%d+):(%d+)");
        --转化为时间戳
        local timestamp = os.time({year=y, month = m, day = d, hour = _hour, min = _min, sec = _sec});
        if (timestamp > nowTime) then
            table.insert(unreachableSkills,k)
        end
    end



    local recommendJson = {}
    recommendJson["recommendType"] = "generalReply"
    recommendJson["reply"] = tipString
    return JSON.encode(recommendJson)
end

