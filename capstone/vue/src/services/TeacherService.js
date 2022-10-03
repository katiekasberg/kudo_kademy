import axios from 'axios';

export default {
    
    
    teacher() {
        return axios.get('/teacher')
    },

    getOwnClasses(){
        return axios.get('/classes')
    },

    addStudentToClass(){
        return axios.post('/class-roster')
    },

    getStaffProfile(teacherId){
        return axios.get(`/teacher/${teacherId}`)
    },

    getTeacherClassesById(teacherId){
        return axios.get(`/teacher/${teacherId}/classes`)
    },
}