<template>
  <div>
      <table>
          <tr>
              <th></th>
          </tr>
      </table>
  </div>
</template>

<script>
import KudosService from '../services/KudosService'
import StudentService from '../services/StudentService';
export default {
    data() {
        return {
            GradeLevelKudos: [],
            graduationYear: ''
        }
    },

    methods: {
        getKudosByGradYear(){
            KudosService.getKudosByGradYear(this.graduationYear).then((response) => {
                this.GradeLevelKudos = response.data;
            });
        },
    },
    created(){
        StudentService.getStudentProfileById(this.$store.state.activeStudentId).then((response) => {
            this.graduationYear = response.data.graduationYear;
        })
    }

}
</script>

<style>

</style>