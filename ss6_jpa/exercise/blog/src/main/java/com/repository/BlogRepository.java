package com.repository;

import com.model.BlogModel;
import com.mysql.cj.log.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogModel,Long> {

}
