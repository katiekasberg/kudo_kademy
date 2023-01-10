import axios from 'axios';

export default {

    teacher() {
        return axios.get('/teacher')
    },

    getOwnClasses() {
        return axios.get('/classes')
    },

    getStudentsInClass(classInfoId) {
        return axios.get(`/class-roster/${classInfoId}`)
    },

    addStudentToClass(classInfoStudent) {
        return axios.post('/class-roster', classInfoStudent)
    },

    getStaffProfile(staffId) {
        return axios.get(`/staff-profiles/${staffId}`)
    },

    getTeacherClassesById(staffId) {
        return axios.get(`/staff-profiles/${staffId}/classes`)
    },

    addNewClass(newClass) {
        return axios.post('/classes', newClass);
    },

    getClassDetailByClassId(classInfoId) {
        return axios.get(`/classes/${classInfoId}`)
    }
}