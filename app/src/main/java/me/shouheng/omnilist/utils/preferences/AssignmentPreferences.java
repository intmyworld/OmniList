package me.shouheng.omnilist.utils.preferences;

import android.content.Context;

import me.shouheng.omnilist.PalmApp;
import me.shouheng.omnilist.R;
import me.shouheng.omnilist.model.enums.Operation;
import me.shouheng.omnilist.model.enums.Priority;
import me.shouheng.omnilist.utils.base.BasePreferences;

public class AssignmentPreferences extends BasePreferences {

    private static AssignmentPreferences preferences;

    public static AssignmentPreferences getInstance() {
        if (preferences == null) {
            synchronized (ActionPreferences.class) {
                if (preferences == null) {
                    preferences = new AssignmentPreferences(PalmApp.getContext());
                }
            }
        }
        return preferences;
    }

    private AssignmentPreferences(Context context) {
        super(context);
    }

    public Operation getSlideLeftOperation() {
        return Operation.getTypeById(getInt(R.string.key_assignment_slide_left, Operation.TRASH.id));
    }

    public void setSlideLeftOperation(Operation operation) {
        putInt(R.string.key_assignment_slide_left, operation.id);
    }

    public Operation getSlideRightOperation() {
        return Operation.getTypeById(getInt(R.string.key_assignment_slide_right, Operation.ARCHIVE.id));
    }

    public void setSlideRightOperation(Operation operation) {
        putInt(R.string.key_assignment_slide_right, operation.id);
    }

    public boolean isAssignmentSlideEnable() {
        return getBoolean(R.string.key_assignment_slide_enable, true);
    }

    public boolean showCompleted() {
        return getBoolean(R.string.key_assignment_completed, true);
    }

    public void setShowCompleted(boolean showCompleted) {
        putBoolean(R.string.key_assignment_completed, showCompleted);
    }

    public Priority getDefaultPriority() {
        return Priority.LEVEL_03;
    }
}
