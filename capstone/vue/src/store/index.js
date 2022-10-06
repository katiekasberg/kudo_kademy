import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    studentProfiles: [],
    activeStudentProfile: {
      id: 0,
      firstName: '',
      lastName: '',
      email: '',
      image: '',
      schoolId: 0,
      graduationYear: 0
    },
    activeStudentId: '',
    
    activeStaffProfile: {
      id: 0,
      firstName: '',
      lastName: '',
      email: '',
      image: '',      
    },

    activeParentProfile: {
      id: 0,
      firstName: '',
      lastName: '',
      email: '',
      image: '',
      phoneNumber: '',
      address: '',
    },

    kudoTypes: [],
    studentKudos:[],
    activeKudoType: {
      id: 0,
      name: '',
      description: '',
      value: 0
    },
    latestAnnouncement: [],
    
    token: currentToken || '',
    user: currentUser || {authorities: ['']}
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {authorities: ['']};
      axios.defaults.headers.common = {};
    },
    SET_KUDO_TYPES(state, data) {
      state.kudoTypes = data;
    },
    SET_ACTIVE_KUDO_TYPE(state, data) {
      state.activeKudoType = data;
    },
    SET_STUDENT_PROFILES(state, data) {
      state.studentProfiles = data;
    },
    SET_STUDENT_KUDOS(state, data){
      state.studentKudos = data;
    },
    SET_ACTIVE_STUDENT_PROFILE(state, data) {
      state.activeStudentProfile = data;
    },
    SET_ACTIVE_STUDENT_ID(state, data) {
      state.activeStudentId = data;
    },
    SET_ACTIVE_STAFF_PROFILE(state, data) {
      state.activeStaffProfile = data;
    },
    SET_ACTIVE_PARENT_PROFILE(state, data) {
      state.activeParentProfile = data;
    },
    SET_LATEST_ANNOUNCEMENT(state, data) {
      state.latestAnnouncement = data;
    },
  }
})
