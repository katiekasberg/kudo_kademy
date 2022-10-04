import axios from 'axios';

export default {
    
    
    teacher() {
        return axios.get('/teacher')
    },

    getOwnClasses(){
        return axios.get('/classes')
    },

    getStudentsInClass(classInfoId){
        return axios.get(`/class-roster/${classInfoId}`)
    },

    addStudentToClass(classInfoStudent){
        return axios.post('/class-roster', classInfoStudent)
    }
}