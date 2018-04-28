package com.example.jahid.acm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jahid.acm.model.Adapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    RecyclerView recyclerView;
    String[] items={"Item 0", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11"};
    private View view;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_events, container, false);
        recyclerView= view.findViewById(R.id.evedesi);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new Adapter(getEventContents(),getActivity()));

        return view;

    }

    private List<EventContent> getEventContents() {
        List<EventContent> eventContentList = new ArrayList<>();
        eventContentList.add(new EventContent("Capstone Innovation Challenge\n","Capstone Innovation challenge –Idea Generation\n" +
                "NSU ACM Student Chapter is back with the “Capstone Innovation Challenge- Season two” after\n" +
                "a successful season one. The idea of “Capstone Innovation Challenge” focuses on the 8 months\n" +
                "long course that final year students of engineering department of NSU go through to display a\n" +
                "custom designed project using the knowledge they earned on a course of 3 years at university.\n" +
                "And NSU ACM Student chapter started the practise of interactive session between students and\n" +
                "industry personnel to harness interest in technological entrepreneurship in a sustainable way\n" +
                "among the graduating community.\n" +
                "\n" +
                "On May 25 th , 2017, the first part of innovation challenge “IDEA GENERATION” was held at\n" +
                "NSU auditorium where distinguished speakers from industry and faculty members of ECE\n" +
                "department addressed the students. NSU ACM Student Chapter arranged this interactive session\n" +
                "between students, faculties and experts from industry to give the students a real life scenario of\n" +
                "market at present and to foster their creativity and innovation in building new technical\n" +
                "opportunities.\n" +
                ".\n" +
                "At first the session chair, Dr.Rezaul Bari, ECE department chair inaugurated the ceremony and\n" +
                "welcomed the guests and all other faculties and students. He was followed by Dr. M.\n" +
                "Rokonuzzaman who talked about how students should think about not just merely a project but a\n" +
                "sustainable one for the market. He mentioned that “It is easier to generate an idea, complex part\n" +
                "is to bring that in market and sustain” and accordingly advised the students. Then came\n" +
                "Dr.Sazzad Hossain, faculty advisor of NSU ACM Student branch, and he emphasized on\n" +
                "connecting with market, acquire knowledge about current situation and thereby to proceed\n" +
                "further.\n" +
                "Then came one of our key speaker MD.Samsul Haque, Manager of digital innovation LEADS\n" +
                "Corp LTD. He gave the students some key-word to realize their ideas into reality – Discover,\n" +
                "define, develop and deliver. In his speech he encouraged the students to generate more ideas with\n" +
                "IOT(Internet of Things) related to fields like agriculture, healthcare , smart home system etc.\n" +
                "Later, Saddam Hussain, Co-Founder of Business Accelerate LTD told about his journey from\n" +
                "being a student to an entrepreneur. He spoke about his repeated attempts and consequent failures\n" +
                "in his starting years and how he became successful in the course of time. He showed the real life\n" +
                "challenges of a startup and encouraged the students to participate in the market through their\n" +
                "innovative works and advised to nurture their passion. Then came MR. Nayeem Ahmed COO of\n" +
                "Ctrends Software and Services LTD. He gave the students an idea about a software named\n" +
                "“Drive-Well” and encouraged the students to develop a prototype for that.\n" +
                "\n" +
                "There were some questions from students side and those queries were solved brilliantly. In the\n" +
                "last minutes, Mr Mohammad Samsul Haque, announced that he would offer any kind of\n" +
                "technical help to the students if they are interested to work with IoT(internet of things) and the\n" +
                "students appreciated it. Lastly, Dr. Kazi Mohammad Abdus Salam ended the program with his\n" +
                "conclusion speech and thanked all of our guests for sharing their valuable knowledge with the\n" +
                "students.",R.drawable.intrauniprogcon));
        return eventContentList;
    }

}
