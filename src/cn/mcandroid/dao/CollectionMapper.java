package cn.mcandroid.dao;

import cn.mcandroid.pojo.Collection;
import cn.mcandroid.pojo.CollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    long countByExample(CollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    int deleteByExample(CollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    int deleteByPrimaryKey(Integer collectionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    int insert(Collection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    int insertSelective(Collection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    List<Collection> selectByExample(CollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    Collection selectByPrimaryKey(Integer collectionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    int updateByExampleSelective(@Param("record") Collection record, @Param("example") CollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    int updateByExample(@Param("record") Collection record, @Param("example") CollectionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    int updateByPrimaryKeySelective(Collection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collection
     *
     * @mbg.generated Tue Nov 27 09:47:32 CST 2018
     */
    int updateByPrimaryKey(Collection record);
}