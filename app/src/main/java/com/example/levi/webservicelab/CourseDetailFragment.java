package com.example.levi.webservicelab;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.levi.webservicelab.model.Course;


/**
 * A simple {@link Fragment} subclass.
 */
public class CourseDetailFragment extends Fragment {

    public static final String COURSE_ITEM_SELECTED = "course_item_selected";

    private TextView mCourseIdTextView;
    private TextView mCourseShortDescTextView;
    private TextView mCourseLongDescTextView;
    private TextView mCoursePrereqsTextView;



    public CourseDetailFragment() {
        // Required empty public constructor
    }


    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_course_detail, container, false);
        mCourseIdTextView = (TextView) view.findViewById(R.id.course_item_id);
        mCourseShortDescTextView = (TextView) view.findViewById(R.id.course_short_desc);
        mCourseLongDescTextView = (TextView) view.findViewById(R.id.course_long_desc);
        mCoursePrereqsTextView = (TextView) view.findViewById(R.id.course_prereqs);

        FloatingActionButton floatingActionButton = (FloatingActionButton)
                getActivity().findViewById(R.id.fab);
        floatingActionButton.show();

        return view;
    }

    @Override public void onStart() {
        super.onStart();
             // During startup, check if there are arguments passed to the fragment.
             // onStart is a good place to do this because the layout has already been
             // applied to the fragment at this point so we can safely call the method
             // below that sets the article text.

        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateView((Course) args.getSerializable(COURSE_ITEM_SELECTED));
        }
    }

    public void updateView(Course course) {
        if (course != null) {
            mCourseIdTextView.setText(course.getmCourseId());
            mCourseShortDescTextView.setText(course.getmShortDescription());
            mCourseLongDescTextView.setText(course.getmLongDescription());
            mCoursePrereqsTextView.setText(course.getmPrereqs());
        }

    }



}
