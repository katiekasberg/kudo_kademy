import axios from 'axios';

export default {

    teacher(user) {
        return axios.post('/teacher', user)
    },

    SendKudos(user) {
        return axios.post('/SendKudos', user)
    }

}