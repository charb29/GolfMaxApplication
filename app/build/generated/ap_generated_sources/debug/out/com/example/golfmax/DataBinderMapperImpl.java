package com.example.golfmax;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.golfmax.databinding.ActivityCourseLeaderboardBindingImpl;
import com.example.golfmax.databinding.ActivityCourseListBindingImpl;
import com.example.golfmax.databinding.ActivityHomeBindingImpl;
import com.example.golfmax.databinding.ActivityLoginBindingImpl;
import com.example.golfmax.databinding.ActivityNewRoundBindingImpl;
import com.example.golfmax.databinding.ActivityPersonalScoresBindingImpl;
import com.example.golfmax.databinding.ActivityRegistrationBindingImpl;
import com.example.golfmax.databinding.ActivityScoreCardFront9BindingImpl;
import com.example.golfmax.databinding.ActivityUserProfileBindingImpl;
import com.example.golfmax.databinding.CourseLeaderboardRecyclerViewBindingImpl;
import com.example.golfmax.databinding.CourseListRecyclerViewBindingImpl;
import com.example.golfmax.databinding.NewRoundRecyclerViewBindingImpl;
import com.example.golfmax.databinding.PersonalScoresRecyclerViewBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCOURSELEADERBOARD = 1;

  private static final int LAYOUT_ACTIVITYCOURSELIST = 2;

  private static final int LAYOUT_ACTIVITYHOME = 3;

  private static final int LAYOUT_ACTIVITYLOGIN = 4;

  private static final int LAYOUT_ACTIVITYNEWROUND = 5;

  private static final int LAYOUT_ACTIVITYPERSONALSCORES = 6;

  private static final int LAYOUT_ACTIVITYREGISTRATION = 7;

  private static final int LAYOUT_ACTIVITYSCORECARDFRONT9 = 8;

  private static final int LAYOUT_ACTIVITYUSERPROFILE = 9;

  private static final int LAYOUT_COURSELEADERBOARDRECYCLERVIEW = 10;

  private static final int LAYOUT_COURSELISTRECYCLERVIEW = 11;

  private static final int LAYOUT_NEWROUNDRECYCLERVIEW = 12;

  private static final int LAYOUT_PERSONALSCORESRECYCLERVIEW = 13;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(13);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.activity_course_leaderboard, LAYOUT_ACTIVITYCOURSELEADERBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.activity_course_list, LAYOUT_ACTIVITYCOURSELIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.activity_home, LAYOUT_ACTIVITYHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.activity_new_round, LAYOUT_ACTIVITYNEWROUND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.activity_personal_scores, LAYOUT_ACTIVITYPERSONALSCORES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.activity_registration, LAYOUT_ACTIVITYREGISTRATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.activity_score_card_front9, LAYOUT_ACTIVITYSCORECARDFRONT9);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.activity_user_profile, LAYOUT_ACTIVITYUSERPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.course_leaderboard_recycler_view, LAYOUT_COURSELEADERBOARDRECYCLERVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.course_list_recycler_view, LAYOUT_COURSELISTRECYCLERVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.new_round_recycler_view, LAYOUT_NEWROUNDRECYCLERVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.golfmax.R.layout.personal_scores_recycler_view, LAYOUT_PERSONALSCORESRECYCLERVIEW);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCOURSELEADERBOARD: {
          if ("layout/activity_course_leaderboard_0".equals(tag)) {
            return new ActivityCourseLeaderboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_course_leaderboard is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCOURSELIST: {
          if ("layout/activity_course_list_0".equals(tag)) {
            return new ActivityCourseListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_course_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHOME: {
          if ("layout/activity_home_0".equals(tag)) {
            return new ActivityHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYNEWROUND: {
          if ("layout/activity_new_round_0".equals(tag)) {
            return new ActivityNewRoundBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_new_round is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPERSONALSCORES: {
          if ("layout/activity_personal_scores_0".equals(tag)) {
            return new ActivityPersonalScoresBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_personal_scores is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREGISTRATION: {
          if ("layout/activity_registration_0".equals(tag)) {
            return new ActivityRegistrationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_registration is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSCORECARDFRONT9: {
          if ("layout/activity_score_card_front9_0".equals(tag)) {
            return new ActivityScoreCardFront9BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_score_card_front9 is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYUSERPROFILE: {
          if ("layout/activity_user_profile_0".equals(tag)) {
            return new ActivityUserProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_user_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_COURSELEADERBOARDRECYCLERVIEW: {
          if ("layout/course_leaderboard_recycler_view_0".equals(tag)) {
            return new CourseLeaderboardRecyclerViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for course_leaderboard_recycler_view is invalid. Received: " + tag);
        }
        case  LAYOUT_COURSELISTRECYCLERVIEW: {
          if ("layout/course_list_recycler_view_0".equals(tag)) {
            return new CourseListRecyclerViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for course_list_recycler_view is invalid. Received: " + tag);
        }
        case  LAYOUT_NEWROUNDRECYCLERVIEW: {
          if ("layout/new_round_recycler_view_0".equals(tag)) {
            return new NewRoundRecyclerViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for new_round_recycler_view is invalid. Received: " + tag);
        }
        case  LAYOUT_PERSONALSCORESRECYCLERVIEW: {
          if ("layout/personal_scores_recycler_view_0".equals(tag)) {
            return new PersonalScoresRecyclerViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for personal_scores_recycler_view is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(46);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "averageScore");
      sKeys.put(2, "course");
      sKeys.put(3, "courseName");
      sKeys.put(4, "courseRating");
      sKeys.put(5, "email");
      sKeys.put(6, "front9Score");
      sKeys.put(7, "guest1");
      sKeys.put(8, "guest1Presenter");
      sKeys.put(9, "guest1Score");
      sKeys.put(10, "guest2");
      sKeys.put(11, "guest2Presenter");
      sKeys.put(12, "guest2Score");
      sKeys.put(13, "guest3");
      sKeys.put(14, "guest3Presenter");
      sKeys.put(15, "guest3Score");
      sKeys.put(16, "handicapIndex");
      sKeys.put(17, "hole1");
      sKeys.put(18, "hole10");
      sKeys.put(19, "hole11");
      sKeys.put(20, "hole12");
      sKeys.put(21, "hole13");
      sKeys.put(22, "hole14");
      sKeys.put(23, "hole15");
      sKeys.put(24, "hole16");
      sKeys.put(25, "hole17");
      sKeys.put(26, "hole18");
      sKeys.put(27, "hole2");
      sKeys.put(28, "hole3");
      sKeys.put(29, "hole4");
      sKeys.put(30, "hole5");
      sKeys.put(31, "hole6");
      sKeys.put(32, "hole7");
      sKeys.put(33, "hole8");
      sKeys.put(34, "hole9");
      sKeys.put(35, "password");
      sKeys.put(36, "presenter");
      sKeys.put(37, "roundsPlayed");
      sKeys.put(38, "score");
      sKeys.put(39, "scorePresenter");
      sKeys.put(40, "slopeRating");
      sKeys.put(41, "stats");
      sKeys.put(42, "user");
      sKeys.put(43, "userPresenter");
      sKeys.put(44, "userScore");
      sKeys.put(45, "username");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(13);

    static {
      sKeys.put("layout/activity_course_leaderboard_0", com.example.golfmax.R.layout.activity_course_leaderboard);
      sKeys.put("layout/activity_course_list_0", com.example.golfmax.R.layout.activity_course_list);
      sKeys.put("layout/activity_home_0", com.example.golfmax.R.layout.activity_home);
      sKeys.put("layout/activity_login_0", com.example.golfmax.R.layout.activity_login);
      sKeys.put("layout/activity_new_round_0", com.example.golfmax.R.layout.activity_new_round);
      sKeys.put("layout/activity_personal_scores_0", com.example.golfmax.R.layout.activity_personal_scores);
      sKeys.put("layout/activity_registration_0", com.example.golfmax.R.layout.activity_registration);
      sKeys.put("layout/activity_score_card_front9_0", com.example.golfmax.R.layout.activity_score_card_front9);
      sKeys.put("layout/activity_user_profile_0", com.example.golfmax.R.layout.activity_user_profile);
      sKeys.put("layout/course_leaderboard_recycler_view_0", com.example.golfmax.R.layout.course_leaderboard_recycler_view);
      sKeys.put("layout/course_list_recycler_view_0", com.example.golfmax.R.layout.course_list_recycler_view);
      sKeys.put("layout/new_round_recycler_view_0", com.example.golfmax.R.layout.new_round_recycler_view);
      sKeys.put("layout/personal_scores_recycler_view_0", com.example.golfmax.R.layout.personal_scores_recycler_view);
    }
  }
}
