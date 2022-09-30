import axios from 'axios';

export default {

    //returns a list of student names and their total house points
    getPointsForAllStudents() {
        return axios.get('/student-points')
    },

    //returns a list of grades and their total house points
    getPointsForAllGrades() {
        return axios.get('/grade-points')
    },

    //returns a list of classes and their total house points
    getPointsForAllClasses() {
        return axios.get('/class-points')
    }

}