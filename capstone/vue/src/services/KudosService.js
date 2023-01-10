import axios from 'axios';

export default {


    //send kudos to a student
    SendKudos(kudo) {
        return axios.post('/kudos', kudo)
    },

    //returns a kudo entry matching the kudo id
    getKudoById(kudoId) {
        return axios.get(`/kudos/${kudoId}`)
    },

    //get all kudos related to user
    getUserKudos() {
        return axios.get('/kudos')
    },

    //get all kudos related to class
    getKudosByClass(classId) {
        return axios.get(`/class-kudos/${classId}`)
    },

    //get all kudos related to a student id
    getKudosByStudentId(studentId) {
        return axios.get(`/student-kudos/${studentId}`)
    },

    //get all kudos for all students
    getKudos(){
        return axios.get('/student-kudos')
    },

    //get list of kudo types
    getKudoTypes() {
        return axios.get('/kudo-types')
    },

    //get all kudos related to class
    getKudosByGradYear(graduationYear) {
        return axios.get(`/kudos/gradyear/${graduationYear}`)
    },

    //get kudo type by kudo type id
    getKudoTypeById(kudoTypeId) {
        return axios.get(`/kudo-types/${kudoTypeId}`)
    },

    //create new kudo type
    addKudoType(kudoType) {
        return axios.post('/kudo-types', kudoType)
    },

    //update kudo type by kudo type id
    updateKudoType(kudoTypeId, kudoType) {
        return axios.put(`/kudo-types/${kudoTypeId}`, kudoType)
    },

    

}