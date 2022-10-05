import axios from 'axios';

export default {
    //get parent profile by id
    getParentProfile(parentId){
        return axios.get(`/parent-profile/${parentId}`);
    },

    //get students assigned to parentId
    getStudentsByParentId(parentId){
        return axios.get(`/parent-profile/${parentId}/children`);
    },

    //assign a student to parentId
    addStudentToParent(student){
        return axios.post(`parent-profile/claim`, student);
    },

    //get a list of students the parent hasn't claimed
    getListofUnclaimedStudents(parentId){
        return axios.get(`parent-profile/${parentId}/students`)
    }
    
}