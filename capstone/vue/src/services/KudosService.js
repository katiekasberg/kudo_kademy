import axios from 'axios';

export default {

    teacher() {
        return axios.get('/teacher')
    },

    SendKudos(kudo) {
        return axios.post('/kudos', kudo)
    }

}