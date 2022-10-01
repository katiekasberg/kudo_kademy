import axios from 'axios';

export default {

    getStudentProfiles() {
        return axios.get('/student-profiles')
    },
    getStudentProfilesByParentId() {
        return axios.get('/student_profiles')
    }
}