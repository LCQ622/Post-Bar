package cn.mcandroid.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepliesExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public RepliesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRepliesIdIsNull() {
            addCriterion("replies_id is null");
            return (Criteria) this;
        }

        public Criteria andRepliesIdIsNotNull() {
            addCriterion("replies_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepliesIdEqualTo(Integer value) {
            addCriterion("replies_id =", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdNotEqualTo(Integer value) {
            addCriterion("replies_id <>", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdGreaterThan(Integer value) {
            addCriterion("replies_id >", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("replies_id >=", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdLessThan(Integer value) {
            addCriterion("replies_id <", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdLessThanOrEqualTo(Integer value) {
            addCriterion("replies_id <=", value, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdIn(List<Integer> values) {
            addCriterion("replies_id in", values, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdNotIn(List<Integer> values) {
            addCriterion("replies_id not in", values, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdBetween(Integer value1, Integer value2) {
            addCriterion("replies_id between", value1, value2, "repliesId");
            return (Criteria) this;
        }

        public Criteria andRepliesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("replies_id not between", value1, value2, "repliesId");
            return (Criteria) this;
        }

        public Criteria andContentIdIsNull() {
            addCriterion("content_id is null");
            return (Criteria) this;
        }

        public Criteria andContentIdIsNotNull() {
            addCriterion("content_id is not null");
            return (Criteria) this;
        }

        public Criteria andContentIdEqualTo(Integer value) {
            addCriterion("content_id =", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotEqualTo(Integer value) {
            addCriterion("content_id <>", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdGreaterThan(Integer value) {
            addCriterion("content_id >", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_id >=", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLessThan(Integer value) {
            addCriterion("content_id <", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLessThanOrEqualTo(Integer value) {
            addCriterion("content_id <=", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdIn(List<Integer> values) {
            addCriterion("content_id in", values, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotIn(List<Integer> values) {
            addCriterion("content_id not in", values, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdBetween(Integer value1, Integer value2) {
            addCriterion("content_id between", value1, value2, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("content_id not between", value1, value2, "contentId");
            return (Criteria) this;
        }

        public Criteria andRepliesDateIsNull() {
            addCriterion("replies_date is null");
            return (Criteria) this;
        }

        public Criteria andRepliesDateIsNotNull() {
            addCriterion("replies_date is not null");
            return (Criteria) this;
        }

        public Criteria andRepliesDateEqualTo(Date value) {
            addCriterion("replies_date =", value, "repliesDate");
            return (Criteria) this;
        }

        public Criteria andRepliesDateNotEqualTo(Date value) {
            addCriterion("replies_date <>", value, "repliesDate");
            return (Criteria) this;
        }

        public Criteria andRepliesDateGreaterThan(Date value) {
            addCriterion("replies_date >", value, "repliesDate");
            return (Criteria) this;
        }

        public Criteria andRepliesDateGreaterThanOrEqualTo(Date value) {
            addCriterion("replies_date >=", value, "repliesDate");
            return (Criteria) this;
        }

        public Criteria andRepliesDateLessThan(Date value) {
            addCriterion("replies_date <", value, "repliesDate");
            return (Criteria) this;
        }

        public Criteria andRepliesDateLessThanOrEqualTo(Date value) {
            addCriterion("replies_date <=", value, "repliesDate");
            return (Criteria) this;
        }

        public Criteria andRepliesDateIn(List<Date> values) {
            addCriterion("replies_date in", values, "repliesDate");
            return (Criteria) this;
        }

        public Criteria andRepliesDateNotIn(List<Date> values) {
            addCriterion("replies_date not in", values, "repliesDate");
            return (Criteria) this;
        }

        public Criteria andRepliesDateBetween(Date value1, Date value2) {
            addCriterion("replies_date between", value1, value2, "repliesDate");
            return (Criteria) this;
        }

        public Criteria andRepliesDateNotBetween(Date value1, Date value2) {
            addCriterion("replies_date not between", value1, value2, "repliesDate");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table replies
     *
     * @mbg.generated do_not_delete_during_merge Tue Nov 27 09:47:32 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table replies
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}