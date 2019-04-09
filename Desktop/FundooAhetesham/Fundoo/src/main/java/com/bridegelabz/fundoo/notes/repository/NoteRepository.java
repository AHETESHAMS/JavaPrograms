package com.bridegelabz.fundoo.notes.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bridegelabz.fundoo.notes.model.Notes;
@Repository
public interface NoteRepository extends  CrudRepository<Notes, Integer>
{
	 public Optional<Notes> findById(int id);
}
