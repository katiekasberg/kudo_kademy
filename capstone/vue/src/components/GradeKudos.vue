<template>
  <div>
      <table>
          <tr>
              <th>Name</th>
              <th>Kudo Type</th>
              <th>Kudo Description</th>
              <th>Points</th>
          </tr>
          <tr
          v-for="kudo in this.GradeLevelKudos"
          v-bind:key="kudo.id"
          v-bind:value="kudo.id"
          >
              <td>{{kudo.firstName}} {{kudo.lastName}}</td>
              <td>{{kudo.kudoTypeName}}</td>
              <td>{{kudo.kudoTypeDescription}}</td>
              <td>{{kudo.typeValue}}</td>
          </tr>
      </table>
      graduationYear{{this.graduationYear}}
      testing store: {{this.$store.state.activeStudentId}}
  </div>
</template>

<script>
import KudosService from '../services/KudosService'
import StudentService from '../services/StudentService';
export default {
    data() {
        return {
            GradeLevelKudos: [],
            graduationYear: 0,
        }
    },

    methods: {
        getGraduationYear(){
            StudentService.getStudentProfileById(this.$store.state.activeStudentId).then((response) => {
                this.graduationYear = response.data.graduationYear;
                    this.getKudosByGradYear();
            });
        },
        
        getKudosByGradYear(){
            KudosService.getKudosByGradYear(this.graduationYear).then((response) => {
                this.GradeLevelKudos = response.data;
            });
        },
    },
    created(){
        this.getGraduationYear();
    }

}
</script>

<style>

</style>