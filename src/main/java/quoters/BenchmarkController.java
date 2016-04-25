package quoters;

/**
 * Created by Jeka on 03/10/2015.
 */
public class BenchmarkController implements BenchmarkControllerMBean {
    private boolean enabled;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
