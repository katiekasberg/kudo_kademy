import axios from 'axios';

export default {
    
    
    teacher() {
        return axios.get('/teacher')
    },
}