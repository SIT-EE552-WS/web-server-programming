package edu.stevens.friccobo.demo1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.Map;

@Component
@ApplicationScope
public class AssignmentMap {
    private final Map<Integer, String> assignmentMap = new HashMap<>();

    public String get(int i){
        return assignmentMap.get(i);
    }

    public void put(int id, String url){
        assignmentMap.put(id, url);
    }

    public String toString(){
        return assignmentMap.toString();
    }
}
