import axios from 'axios';

export default {

    getStudentProfiles() {
        return axios.get('/student-profiles')
    }
}