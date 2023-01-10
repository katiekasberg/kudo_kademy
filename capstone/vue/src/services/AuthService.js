import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  createProfile(profile){
    return axios.post('/profiles', profile)
  },

  createStudent(student){
    return axios.post('/students', student)
  },

  createParent(parent){
    return axios.post('/parents', parent)
  }

}
