package litepal_class;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.LitePalSupport;

public class Body_Point extends LitePalSupport {
    private int body_points_ID;

    private String Bname;
    private String Btime;

    private String image_path_zhengmianzhao;
    private String image_path_ceshenzhao;

    private int person_num;

    private double top_head_x=0d;
    private double top_head_y=0d;
    private double top_head_score=0d;

    private double left_eye_x=0d;
    private double left_eye_y=0d;
    private double left_eye_score=0d;
    private double right_eye_x=0d;
    private double right_eye_y=0d;
    private double right_eye_score=0d;

    private double nose_x=0d;
    private double nose_y=0d;
    private double nose_score=0d;

    private double left_ear_x=0d;
    private double left_ear_y=0d;
    private double left_ear_score=0d;

    private double right_ear_x=0d;
    private double right_ear_y=0d;
    private double right_ear_score=0d;

    private double left_mouth_corner_x=0d;
    private double left_mouth_corner_y=0d;
    private double left_mouth_corner_score=0d;

    private double right_mouth_corner_x=0d;
    private double right_mouth_corner_y=0d;
    private double right_mouth_corner_score =0d;

    private double neck_x=0d;
    private double neck_y=0d;
    private double neck_score=0d;

    private double left_shoulder_x=0d;
    private double left_shoulder_y=0d;
    private double left_shoulder_score=0d;

    private double right_shoulder_x=0d;
    private double right_shoulder_y=0d;
    private double right_shoulder_score=0d;

    //左手肘
    private double left_elbow_x=0d;
    private double left_elbow_y=0d;
    private double left_elbow_score=0d;

    private double right_elbow_x=0d;
    private double right_elbow_y=0d;
    private double right_elbow_score=0d;

    //左手腕
    private double left_wrist_x=0d;
    private double left_wrist_y=0d;
    private double left_wrist_score=0d;

    private double right_wrist_x=0d;
    private double right_wrist_y=0d;
    private double right_wrist_score=0d;

    //左髋部
    private double left_hip_x=0d;
    private double left_hip_y=0d;
    private double left_hip_score=0d;

    private double right_hip_x=0d;
    private double right_hip_y=0d;
    private double right_hip_score=0d;

    //左膝部
    private double left_knee_x=0d;
    private double left_knee_y=0d;
    private double left_knee_score=0d;

    private double right_knee_x=0d;
    private double right_knee_y=0d;
    private double right_knee_score=0d;

    //左脚踝
    private double left_ankle_x=0d;
    private double left_ankle_y=0d;
    private double left_ankle_score=0d;

    private double right_ankle_x=0d;
    private double right_ankle_y=0d;
    private double right_ankle_score=0d;

    //人体坐标信息
    //人体区域的高度
    private double location_height=0d;
    //人体区域离左边界的距离
    private double location_left=0d;
    //人体区域离上边界的距离
    private double location_top=0d;
    //人体区域的宽度
    private double location_width=0d;
    //人体框的概率分数
    private double location_score=0d;


    /*
    * 返回值为0——代表正确
    * 返回值为1——代表图片里的人数不唯一
    * */
    public int GOGOGO(String s){
        try {
            JSONObject jsonObject=new JSONObject(s);
            setPerson_num(jsonObject.getInt("person_num"));

            if(person_num!=1){
                return 1;
            }

            JSONArray jsonArray1_person_info=new JSONArray(jsonObject.getString("person_info"));
            JSONObject jsonObject01=jsonArray1_person_info.getJSONObject(0);

            JSONObject jsonObject_body_parts=jsonObject01.getJSONObject("body_parts");

            JSONObject jsonObject1=jsonObject_body_parts.getJSONObject("top_head");
            setTop_head_x(jsonObject1.getDouble("x"));
            setTop_head_y(jsonObject1.getDouble("y"));
            setTop_head_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("left_eye");
            setLeft_eye_x(jsonObject1.getDouble("x"));
            setLeft_eye_y(jsonObject1.getDouble("y"));
            setLeft_eye_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("right_eye");
            setRight_eye_x(jsonObject1.getDouble("x"));
            setRight_ear_y(jsonObject1.getDouble("y"));
            setRight_eye_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("nose");
            setNose_x(jsonObject1.getDouble("x"));
            setNose_y(jsonObject1.getDouble("y"));
            setNose_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("left_ear");
            setLeft_ear_x(jsonObject1.getDouble("x"));
            setLeft_ear_y(jsonObject1.getDouble("y"));
            setLeft_ear_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("right_ear");
            setRight_ear_x(jsonObject1.getDouble("x"));
            setRight_ear_y(jsonObject1.getDouble("y"));
            setRight_ear_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("left_mouth_corner");
            setLeft_mouth_corner_x(jsonObject1.getDouble("x"));
            setLeft_mouth_corner_y(jsonObject1.getDouble("y"));
            setLeft_mouth_corner_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("right_mouth_corner");
            setRight_mouth_corner_x(jsonObject1.getDouble("x"));
            setRight_mouth_corner_y(jsonObject1.getDouble("y"));
            setRight_mouth_corner_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("neck");
            setNeck_x(jsonObject1.getDouble("x"));
            setNeck_y(jsonObject1.getDouble("y"));
            setNeck_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("left_shoulder");
            setLeft_shoulder_x(jsonObject1.getDouble("x"));
            setLeft_shoulder_y(jsonObject1.getDouble("y"));
            setLeft_shoulder_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("right_shoulder");
            setRight_shoulder_x(jsonObject1.getDouble("x"));
            setRight_shoulder_y(jsonObject1.getDouble("y"));
            setRight_shoulder_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("left_elbow");
            setLeft_elbow_x(jsonObject1.getDouble("x"));
            setLeft_elbow_y(jsonObject1.getDouble("y"));
            setLeft_elbow_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("right_elbow");
            setRight_elbow_x(jsonObject1.getDouble("x"));
            setRight_elbow_y(jsonObject1.getDouble("y"));
            setRight_elbow_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("left_wrist");
            setLeft_wrist_x(jsonObject1.getDouble("x"));
            setLeft_wrist_y(jsonObject1.getDouble("y"));
            setLeft_wrist_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("right_wrist");
            setRight_wrist_x(jsonObject1.getDouble("x"));
            setRight_wrist_y(jsonObject1.getDouble("y"));
            setRight_wrist_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("left_hip");
            setLeft_hip_x(jsonObject1.getDouble("x"));
            setLeft_hip_y(jsonObject1.getDouble("y"));
            setLeft_hip_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("right_hip");
            setRight_hip_x(jsonObject1.getDouble("x"));
            setRight_hip_y(jsonObject1.getDouble("y"));
            setRight_hip_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("left_knee");
            setLeft_knee_x(jsonObject1.getDouble("x"));
            setLeft_knee_y(jsonObject1.getDouble("y"));
            setLeft_knee_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("right_knee");
            setRight_knee_x(jsonObject1.getDouble("x"));
            setRight_knee_y(jsonObject1.getDouble("y"));
            setRight_knee_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("left_ankle");
            setLeft_ankle_x(jsonObject1.getDouble("x"));
            setLeft_ankle_y(jsonObject1.getDouble("y"));
            setLeft_ankle_score(jsonObject1.getDouble("score"));

            jsonObject1=jsonObject_body_parts.getJSONObject("right_ankle");
            setRight_ankle_x(jsonObject1.getDouble("x"));
            setRight_ankle_y(jsonObject1.getDouble("y"));
            setRight_ankle_score(jsonObject1.getDouble("score"));

            jsonObject1=null;

            JSONObject jsonObject_location=jsonObject01.getJSONObject("location");
            setLocation_height(jsonObject_location.getDouble("height"));
            setLocation_left(jsonObject_location.getDouble("left"));
            setLocation_top(jsonObject_location.getDouble("top"));
            setLocation_width(jsonObject_location.getDouble("width"));
            setLocation_score(jsonObject_location.getDouble("score"));



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getBody_points_ID() {
        return body_points_ID;
    }

    public void setBody_points_ID(int body_points_ID) {
        this.body_points_ID = body_points_ID;
    }

    public int getPerson_num() {
        return person_num;
    }

    public void setPerson_num(int person_num) {
        this.person_num = person_num;
    }

    public double getTop_head_x() {
        return top_head_x;
    }

    public void setTop_head_x(double top_head_x) {
        this.top_head_x = top_head_x;
    }

    public double getTop_head_y() {
        return top_head_y;
    }

    public void setTop_head_y(double top_head_y) {
        this.top_head_y = top_head_y;
    }

    public double getTop_head_score() {
        return top_head_score;
    }

    public void setTop_head_score(double top_head_score) {
        this.top_head_score = top_head_score;
    }

    public double getLeft_eye_x() {
        return left_eye_x;
    }

    public void setLeft_eye_x(double left_eye_x) {
        this.left_eye_x = left_eye_x;
    }

    public double getLeft_eye_y() {
        return left_eye_y;
    }

    public void setLeft_eye_y(double left_eye_y) {
        this.left_eye_y = left_eye_y;
    }

    public double getLeft_eye_score() {
        return left_eye_score;
    }

    public void setLeft_eye_score(double left_eye_score) {
        this.left_eye_score = left_eye_score;
    }

    public double getRight_eye_x() {
        return right_eye_x;
    }

    public void setRight_eye_x(double right_eye_x) {
        this.right_eye_x = right_eye_x;
    }

    public double getRight_eye_y() {
        return right_eye_y;
    }

    public void setRight_eye_y(double right_eye_y) {
        this.right_eye_y = right_eye_y;
    }

    public double getRight_eye_score() {
        return right_eye_score;
    }

    public void setRight_eye_score(double right_eye_score) {
        this.right_eye_score = right_eye_score;
    }

    public double getNose_x() {
        return nose_x;
    }

    public void setNose_x(double nose_x) {
        this.nose_x = nose_x;
    }

    public double getNose_y() {
        return nose_y;
    }

    public void setNose_y(double nose_y) {
        this.nose_y = nose_y;
    }

    public double getNose_score() {
        return nose_score;
    }

    public void setNose_score(double nose_score) {
        this.nose_score = nose_score;
    }

    public double getLeft_ear_x() {
        return left_ear_x;
    }

    public void setLeft_ear_x(double left_ear_x) {
        this.left_ear_x = left_ear_x;
    }

    public double getLeft_ear_y() {
        return left_ear_y;
    }

    public void setLeft_ear_y(double left_ear_y) {
        this.left_ear_y = left_ear_y;
    }

    public double getLeft_ear_score() {
        return left_ear_score;
    }

    public void setLeft_ear_score(double left_ear_score) {
        this.left_ear_score = left_ear_score;
    }

    public double getRight_ear_x() {
        return right_ear_x;
    }

    public void setRight_ear_x(double right_ear_x) {
        this.right_ear_x = right_ear_x;
    }

    public double getRight_ear_y() {
        return right_ear_y;
    }

    public void setRight_ear_y(double right_ear_y) {
        this.right_ear_y = right_ear_y;
    }

    public double getRight_ear_score() {
        return right_ear_score;
    }

    public void setRight_ear_score(double right_ear_score) {
        this.right_ear_score = right_ear_score;
    }

    public double getLeft_mouth_corner_x() {
        return left_mouth_corner_x;
    }

    public void setLeft_mouth_corner_x(double left_mouth_corner_x) {
        this.left_mouth_corner_x = left_mouth_corner_x;
    }

    public double getLeft_mouth_corner_y() {
        return left_mouth_corner_y;
    }

    public void setLeft_mouth_corner_y(double left_mouth_corner_y) {
        this.left_mouth_corner_y = left_mouth_corner_y;
    }

    public double getLeft_mouth_corner_score() {
        return left_mouth_corner_score;
    }

    public void setLeft_mouth_corner_score(double left_mouth_corner_score) {
        this.left_mouth_corner_score = left_mouth_corner_score;
    }

    public double getRight_mouth_corner_x() {
        return right_mouth_corner_x;
    }

    public void setRight_mouth_corner_x(double right_mouth_corner_x) {
        this.right_mouth_corner_x = right_mouth_corner_x;
    }

    public double getRight_mouth_corner_y() {
        return right_mouth_corner_y;
    }

    public void setRight_mouth_corner_y(double right_mouth_corner_y) {
        this.right_mouth_corner_y = right_mouth_corner_y;
    }

    public double getRight_mouth_corner_score() {
        return right_mouth_corner_score;
    }

    public void setRight_mouth_corner_score(double right_mouth_corner_score) {
        this.right_mouth_corner_score = right_mouth_corner_score;
    }

    public double getNeck_x() {
        return neck_x;
    }

    public void setNeck_x(double neck_x) {
        this.neck_x = neck_x;
    }

    public double getNeck_y() {
        return neck_y;
    }

    public void setNeck_y(double neck_y) {
        this.neck_y = neck_y;
    }

    public double getNeck_score() {
        return neck_score;
    }

    public void setNeck_score(double neck_score) {
        this.neck_score = neck_score;
    }

    public double getLeft_shoulder_x() {
        return left_shoulder_x;
    }

    public void setLeft_shoulder_x(double left_shoulder_x) {
        this.left_shoulder_x = left_shoulder_x;
    }

    public double getLeft_shoulder_y() {
        return left_shoulder_y;
    }

    public void setLeft_shoulder_y(double left_shoulder_y) {
        this.left_shoulder_y = left_shoulder_y;
    }

    public double getLeft_shoulder_score() {
        return left_shoulder_score;
    }

    public void setLeft_shoulder_score(double left_shoulder_score) {
        this.left_shoulder_score = left_shoulder_score;
    }

    public double getRight_shoulder_x() {
        return right_shoulder_x;
    }

    public void setRight_shoulder_x(double right_shoulder_x) {
        this.right_shoulder_x = right_shoulder_x;
    }

    public double getRight_shoulder_y() {
        return right_shoulder_y;
    }

    public void setRight_shoulder_y(double right_shoulder_y) {
        this.right_shoulder_y = right_shoulder_y;
    }

    public double getRight_shoulder_score() {
        return right_shoulder_score;
    }

    public void setRight_shoulder_score(double right_shoulder_score) {
        this.right_shoulder_score = right_shoulder_score;
    }

    public double getLeft_elbow_x() {
        return left_elbow_x;
    }

    public void setLeft_elbow_x(double left_elbow_x) {
        this.left_elbow_x = left_elbow_x;
    }

    public double getLeft_elbow_y() {
        return left_elbow_y;
    }

    public void setLeft_elbow_y(double left_elbow_y) {
        this.left_elbow_y = left_elbow_y;
    }

    public double getLeft_elbow_score() {
        return left_elbow_score;
    }

    public void setLeft_elbow_score(double left_elbow_score) {
        this.left_elbow_score = left_elbow_score;
    }

    public double getRight_elbow_x() {
        return right_elbow_x;
    }

    public void setRight_elbow_x(double right_elbow_x) {
        this.right_elbow_x = right_elbow_x;
    }

    public double getRight_elbow_y() {
        return right_elbow_y;
    }

    public void setRight_elbow_y(double right_elbow_y) {
        this.right_elbow_y = right_elbow_y;
    }

    public double getRight_elbow_score() {
        return right_elbow_score;
    }

    public void setRight_elbow_score(double right_elbow_score) {
        this.right_elbow_score = right_elbow_score;
    }

    public double getLeft_wrist_x() {
        return left_wrist_x;
    }

    public void setLeft_wrist_x(double left_wrist_x) {
        this.left_wrist_x = left_wrist_x;
    }

    public double getLeft_wrist_y() {
        return left_wrist_y;
    }

    public void setLeft_wrist_y(double left_wrist_y) {
        this.left_wrist_y = left_wrist_y;
    }

    public double getLeft_wrist_score() {
        return left_wrist_score;
    }

    public void setLeft_wrist_score(double left_wrist_score) {
        this.left_wrist_score = left_wrist_score;
    }

    public double getRight_wrist_x() {
        return right_wrist_x;
    }

    public void setRight_wrist_x(double right_wrist_x) {
        this.right_wrist_x = right_wrist_x;
    }

    public double getRight_wrist_y() {
        return right_wrist_y;
    }

    public void setRight_wrist_y(double right_wrist_y) {
        this.right_wrist_y = right_wrist_y;
    }

    public double getRight_wrist_score() {
        return right_wrist_score;
    }

    public void setRight_wrist_score(double right_wrist_score) {
        this.right_wrist_score = right_wrist_score;
    }

    public double getLeft_hip_x() {
        return left_hip_x;
    }

    public void setLeft_hip_x(double left_hip_x) {
        this.left_hip_x = left_hip_x;
    }

    public double getLeft_hip_y() {
        return left_hip_y;
    }

    public void setLeft_hip_y(double left_hip_y) {
        this.left_hip_y = left_hip_y;
    }

    public double getLeft_hip_score() {
        return left_hip_score;
    }

    public void setLeft_hip_score(double left_hip_score) {
        this.left_hip_score = left_hip_score;
    }

    public double getRight_hip_x() {
        return right_hip_x;
    }

    public void setRight_hip_x(double right_hip_x) {
        this.right_hip_x = right_hip_x;
    }

    public double getRight_hip_y() {
        return right_hip_y;
    }

    public void setRight_hip_y(double right_hip_y) {
        this.right_hip_y = right_hip_y;
    }

    public double getRight_hip_score() {
        return right_hip_score;
    }

    public void setRight_hip_score(double right_hip_score) {
        this.right_hip_score = right_hip_score;
    }

    public double getLeft_knee_x() {
        return left_knee_x;
    }

    public void setLeft_knee_x(double left_knee_x) {
        this.left_knee_x = left_knee_x;
    }

    public double getLeft_knee_y() {
        return left_knee_y;
    }

    public void setLeft_knee_y(double left_knee_y) {
        this.left_knee_y = left_knee_y;
    }

    public double getLeft_knee_score() {
        return left_knee_score;
    }

    public void setLeft_knee_score(double left_knee_score) {
        this.left_knee_score = left_knee_score;
    }

    public double getRight_knee_x() {
        return right_knee_x;
    }

    public void setRight_knee_x(double right_knee_x) {
        this.right_knee_x = right_knee_x;
    }

    public double getRight_knee_y() {
        return right_knee_y;
    }

    public void setRight_knee_y(double right_knee_y) {
        this.right_knee_y = right_knee_y;
    }

    public double getRight_knee_score() {
        return right_knee_score;
    }

    public void setRight_knee_score(double right_knee_score) {
        this.right_knee_score = right_knee_score;
    }

    public double getLeft_ankle_x() {
        return left_ankle_x;
    }

    public void setLeft_ankle_x(double left_ankle_x) {
        this.left_ankle_x = left_ankle_x;
    }

    public double getLeft_ankle_y() {
        return left_ankle_y;
    }

    public void setLeft_ankle_y(double left_ankle_y) {
        this.left_ankle_y = left_ankle_y;
    }

    public double getLeft_ankle_score() {
        return left_ankle_score;
    }

    public void setLeft_ankle_score(double left_ankle_score) {
        this.left_ankle_score = left_ankle_score;
    }

    public double getRight_ankle_x() {
        return right_ankle_x;
    }

    public void setRight_ankle_x(double right_ankle_x) {
        this.right_ankle_x = right_ankle_x;
    }

    public double getRight_ankle_y() {
        return right_ankle_y;
    }

    public void setRight_ankle_y(double right_ankle_y) {
        this.right_ankle_y = right_ankle_y;
    }

    public double getRight_ankle_score() {
        return right_ankle_score;
    }

    public void setRight_ankle_score(double right_ankle_score) {
        this.right_ankle_score = right_ankle_score;
    }

    public double getLocation_height() {
        return location_height;
    }

    public void setLocation_height(double location_height) {
        this.location_height = location_height;
    }

    public double getLocation_left() {
        return location_left;
    }

    public void setLocation_left(double location_left) {
        this.location_left = location_left;
    }

    public double getLocation_top() {
        return location_top;
    }

    public void setLocation_top(double location_top) {
        this.location_top = location_top;
    }

    public double getLocation_width() {
        return location_width;
    }

    public void setLocation_width(double location_width) {
        this.location_width = location_width;
    }

    public double getLocation_score() {
        return location_score;
    }

    public void setLocation_score(double location_score) {
        this.location_score = location_score;
    }

    public String getImage_path_zhengmianzhao() {
        return image_path_zhengmianzhao;
    }

    public void setImage_path_zhengmianzhao(String image_path_zhengmianzhao) {
        this.image_path_zhengmianzhao = image_path_zhengmianzhao;
    }

    public String getImage_path_ceshenzhao() {
        return image_path_ceshenzhao;
    }

    public void setImage_path_ceshenzhao(String image_path_ceshenzhao) {
        this.image_path_ceshenzhao = image_path_ceshenzhao;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public String getBtime() {
        return Btime;
    }

    public void setBtime(String btime) {
        Btime = btime;
    }
}
