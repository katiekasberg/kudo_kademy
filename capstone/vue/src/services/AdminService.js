import axios from 'axios';

export default {
    //create an announcement
    createAnnouncement(message){
        return axios.post('/announcement', message);
    },

    //get most recent announcement
    getLatestAnnouncement(){
        return axios.get('/announcement');
    }
}