package com.vn.devmaster.quanlysinhvien.demosinhvien.responsitory;

import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Adress;
import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Student;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentReponsitory extends JpaRepository<Student, Integer> {
    // viết query theo native
//    @Query(nativeQuery = true,value = "select * from student" + "where first_name = :name")
//    List<Student> filterByName(@Param("name") String name);

    //HQL - tìm dữ liệu theo tên sinh viên
    @Query(value = "select s from Student s where s.first_name like concat('%',:name,'%') ")
    List<Student> filterByName(@Param("name") String name);

//    List<Student> finAllByFirstName(String name);

    // lấy toàn bộ dữ liệu address
    @Query(value = "select a from Adress a")
    List<Adress> getAllAddress();

    @Query(value = "select a from Adress a where a.id = :id ")
    Adress getOneAddress(@Param("id") Integer id);


    @Query(value = "select s from Student s where s.adress = (select a from Adress a where a.city like '%Hà Nội%' group by a.id)")
    List<Student>   getAddressHN();
}
