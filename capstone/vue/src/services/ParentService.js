import axios from 'axios';

export default {
    //get parent profile by id
    getParentProfile(parentId){
        return axios.get(`/parent-profile/${parentId}`);
    },
    
}