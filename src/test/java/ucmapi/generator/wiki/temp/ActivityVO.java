package ucmapi.generator.wiki.temp;

import ucmapi.generator.wiki.wikiannoation.ReflectAnnotation;


public class ActivityVO {
    @ReflectAnnotation(val = "活动名称")
    private String activitiesName;

    
      @ReflectAnnotation(val = " 活动时间")
    private String activitiesTime;

    
      @ReflectAnnotation(val = " 活动图片路径")
    private String pic;

    public String getActivitiesName() {
        return activitiesName;
    }

    public void setActivitiesName(String activitiesName) {
        this.activitiesName = activitiesName;
    }

    public String getActivitiesTime() {
        return activitiesTime;
    }

    public void setActivitiesTime(String activitiesTime) {
        this.activitiesTime = activitiesTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}
