import axios from 'axios';

export default {

    getStudentProfiles() {
        return axios.get('/student-profiles')
    },

    getStudentProfileById(studentId) {
        return axios.get(`/student-profiles/${studentId}`);
    }
}