<template>
  <div>
    <form v-on:submit.prevent="addStudent()" action="submit">
      <p>Find your student in our registry to claim them:</p>
      <select v-model="selectedStudent.studentId" name="studentId" id="studentId">
        <option
          v-for="student in this.unclaimedStudents"
          v-bind:key="student.id"
          v-bind:value="student.id"
        >
          {{ student.firstName }} {{ student.lastName }}
        </option>
      </select>
      <label for="message"></label>
      <input v-model="selectedStudent.relation" type="text" name="relation">
      <button type="submit" >Claim Student</button>
    </form>
  </div>
</template>

<script>
import ParentService from "../services/ParentService";
import StudentService from "../services/StudentService";
export default {
  name: "ClaimStudent",
  props: {
    parentId: Number,
  },
  data() {
    return {
      unclaimedStudents: [],
      claimedStudents: [],
      selectedStudent: {
        parentId: this.parentId,
        studentId: "",
        relation: "",
      },
    };
  },
  methods: {
    getUnclaimedStudents() {
      let studentList = [];

      ParentService.getStudentsByParentId(this.parentId).then((response) => {
        this.claimedStudents = response.data;
      });

      StudentService.getStudentProfiles().then((response) => {
        studentList = response.data;
        this.unclaimedStudents = response.data;
      });

      if (this.claimedStudents.length > 0) {
        let filteredStudentList = [];
        for (let i = 0; i < this.claimedStudents.length; i++) {
          filteredStudentList = studentList.filter(
            (student) => student.id !== this.claimedStudents[i].id
          );
          this.unclaimedStudents = filteredStudentList;
          studentList = filteredStudentList;
          
        }
      }
    },
    addStudent() {
      ParentService.addStudentToParent(this.selectedStudent).then(
        (response) => {
          if (response.status === 201) {
            console.log(response.status);
            console.log(this.selectedStudent);
            this.selectedStudent.studentId = "";
            this.selectedStudent.relation = "";
          }
        }
      );
      this.getUnclaimedStudents();
    },
  },
  created() {
    this.getUnclaimedStudents();
  },
};
</script>

<style>
</style>