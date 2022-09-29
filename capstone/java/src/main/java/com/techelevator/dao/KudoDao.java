package com.techelevator.dao;

import com.techelevator.model.exceptions.KudoNotFoundException;
import com.techelevator.model.kudo.Kudo;
import com.techelevator.model.kudo.KudoRequest;
import com.techelevator.model.kudo.KudoType;
import com.techelevator.model.kudo.NewKudoType;

import java.util.List;

public interface KudoDao {

    //get kudo by id
    Kudo getKudoById(int kudoId) throws KudoNotFoundException;

    //get list of kudos by student id
    List<Kudo> getStudentKudos(int StudentId);

    //get list of kudos by class
    List<Kudo> getClassKudos(int classId);

    //get list of kudos for all students
    List<Kudo> getAllKudos();

    //get list of kudo types
    List<KudoType> getTypesOfKudos();

    //TODO: get list of last 10 kudos per student id

    //create a kudo type
    KudoType createKudoType(KudoType newKudoType);

//    //create a kudo type
//    KudoType createKudoType(NewKudoType newKudoType);
    //^^Do we need to differentiate between KudoType and NewKudoType?

    //update a kudo type
    KudoType updateKudoType(KudoType updatedKudoType, int kudoTypeId);

    //submit a kudo request to student
    Kudo submitKudo(int teacherId, KudoRequest newKudoRequest);


}
