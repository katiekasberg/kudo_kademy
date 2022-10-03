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

    getStaffProfile(staffId){
        return axios.get(`/staff-profiles/${staffId}`)
    },

    getTeacherClassesById(staffId){
        return axios.get(`/staff-profiles/${staffId}/classes`)
    },
}