package cn.mcandroid.pojo;

import java.util.Date;

public class Replies {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column replies.replies_id
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    private Integer repliesId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column replies.content_id
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    private Integer contentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column replies.replies_date
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    private Date repliesDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column replies.user_id
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column replies.replies_content
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    private String repliesContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column replies.replies_id
     *
     * @return the value of replies.replies_id
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public Integer getRepliesId() {
        return repliesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column replies.replies_id
     *
     * @param repliesId the value for replies.replies_id
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public void setRepliesId(Integer repliesId) {
        this.repliesId = repliesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column replies.content_id
     *
     * @return the value of replies.content_id
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public Integer getContentId() {
        return contentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column replies.content_id
     *
     * @param contentId the value for replies.content_id
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column replies.replies_date
     *
     * @return the value of replies.replies_date
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public Date getRepliesDate() {
        return repliesDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column replies.replies_date
     *
     * @param repliesDate the value for replies.replies_date
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public void setRepliesDate(Date repliesDate) {
        this.repliesDate = repliesDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column replies.user_id
     *
     * @return the value of replies.user_id
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column replies.user_id
     *
     * @param userId the value for replies.user_id
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column replies.replies_content
     *
     * @return the value of replies.replies_content
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public String getRepliesContent() {
        return repliesContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column replies.replies_content
     *
     * @param repliesContent the value for replies.replies_content
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public void setRepliesContent(String repliesContent) {
        this.repliesContent = repliesContent;
    }
}