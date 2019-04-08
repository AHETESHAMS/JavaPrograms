package com.bridegelabz.fundoo.notes.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bridegelabz.fundoo.notes.model.Notes;
@Repository
public interface NoteRepository extends  CrudRepository<Notes, Integer>
{
//	 public Notes findByIdAndUserId(int id, int userId);
}
