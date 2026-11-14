package com.system.design.projects.JavaQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class freshwork {
//    meetings = [
//    {start: 9, end: 11, priority: 1, id: "X"},
//    {start: 10, end: 12, priority: 2, id: "Y"},
//    {start: 12, end: 14, priority: 0, id: "Z"}
//]


    public static List<String> scheduleMeetings(List<Meeting> meetings){
        Comparator<Meeting> sortMethod = (a,b) -> a.start - b.start;
        Collections.sort(meetings,sortMethod);
        List<Meeting> filterMeeting = new ArrayList<>();
        filterMeeting.add(meetings.get(0));
        int idx = 0;
        for(int i=1;i<meetings.size();i++){
            Meeting m2 = meetings.get(i);
            Meeting m1 = filterMeeting.get(idx);
            if(m2.start<m1.end){
                if(m2.priority<m1.priority){
                    filterMeeting.remove(filterMeeting.size()-1);
                    filterMeeting.add(m2);
                }else if(m2.priority==m1.priority){
                    if(m2.end<m1.end){
                        filterMeeting.remove(filterMeeting.size()-1);
                        filterMeeting.add(m2);
                    }
                }
            }else{
                idx++;
                filterMeeting.add(m2);

            }
        }

        List<String> ids = filterMeeting.stream().map(meeting -> meeting.id).toList();

        return ids;

    }

}

