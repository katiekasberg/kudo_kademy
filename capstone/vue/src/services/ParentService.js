import axios from 'axios';

export default {
    //get parent profile by id
    getParentProfile(parentId){
        return axios.get(`/parent-profile/${parentId}`);
    },

    //get students assigned to parentId
    getStudentsByParentId(parentId){
        return axios.get(`/parent-profile/${parentId}/student`);
    },

    //assign a student to parentId
    addStudentToParent(studentId){
        return axios.post(`parent/student`, studentId);
    }
    
}