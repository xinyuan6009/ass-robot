package com.xinyuan.assist.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinyuan.assist.dao.DBHelper;
import com.xinyuan.assist.dao.VisitDO;
import com.xinyuan.assist.service.VisiterService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class VisiterServiceImpl implements VisiterService {

    private String visitCTKey = "visitCNTKey";

    @Override
    public void visitCtLog() {
        synchronized (VisiterServiceImpl.class) {
            Object cnt = DBHelper.getByK(visitCTKey);
            if (cnt == null) {
                cnt = 1;
                DBHelper.saveKV(visitCTKey, cnt);
            }
            cnt = (int)cnt + 1;
            DBHelper.saveKV(visitCTKey, cnt);
        }
    }

    @Override
    public boolean visitCtLog(String flag, String ip) {
        synchronized (VisiterServiceImpl.class) {
            Map<String, List<VisitDO>> visitDOs = (HashMap<String, List<VisitDO>>)DBHelper.getByK(visitCTKey);
            if (CollectionUtils.isEmpty(visitDOs)) {
                visitDOs = new HashMap<>();
                List<VisitDO> visitDOArr = new ArrayList<>();
                VisitDO visitDO = buildVisitDO(flag, ip);
                visitDOArr.add(visitDO);
                visitDOs.put(ip, visitDOArr);
                return DBHelper.saveKV(visitCTKey, visitDOs);
            }
            List<VisitDO> visitDOArr = visitDOs.get(ip);
            if (CollectionUtils.isEmpty(visitDOArr)) {
                visitDOArr = new ArrayList<>();
                VisitDO visitDO = buildVisitDO(flag, ip);
                visitDOArr.add(visitDO);
                visitDOs.put(ip, visitDOArr);
                return DBHelper.saveKV(visitCTKey, visitDOs);
            }
            VisitDO visitDO =
                visitDOArr.stream().filter(v -> v.getPageFlag().equals(flag)).findFirst().orElse(null);
            if (visitDO == null) {
                visitDO = buildVisitDO(flag, ip);
                visitDOArr.add(visitDO);
                return DBHelper.saveKV(visitCTKey, visitDOs);
            }
            visitDO.setVsCt(visitDO.getVsCt() + 1);
            return DBHelper.saveKV(visitCTKey, visitDOs);
        }

    }

    private VisitDO buildVisitDO(String flag, String ip) {
        VisitDO visitDO = new VisitDO();
        visitDO.setPageFlag(flag);
        visitDO.setVsCt(1);
        visitDO.setVsIP(ip);
        return visitDO;
    }

    @Override
    public Map<String, VisitDO> getVisitCt() {
        return (Map<String, VisitDO>)DBHelper.getByK(visitCTKey);
    }
}
