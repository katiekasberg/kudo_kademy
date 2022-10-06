<template>
  <div>
    <form v-on:submit.prevent="addStudent()" action="submit">
      <p>Find your student in our registry to claim them:</p>
      <select
        v-model="selectedStudent.studentId"
        name="studentId"
        id="studentId"
      >
        <option
          v-for="student in filterStudents"
          v-bind:key="student.id"
          v-bind:value="student.id"
        >
          {{ student.firstName }} {{ student.lastName }}
        </option>
      </select>
      <label for="message"></label>
      <input v-model="selectedStudent.relation" type="text" name="relation" />
      <button type="submit">Claim Student</button>
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
      allStudents: [],
      claimedStudents: [],
      claimedStudentIds: [],
      selectedStudent: {
        parentId: this.parentId,
        studentId: "",
        relation: "",
      },
    };
  },
  computed: {
    filterStudents() {
      let unclaimedStudents = this.allStudents;
      let claimedStudentIds = this.getClaimedStudentIds();
      unclaimedStudents = unclaimedStudents.filter(
        (student) => !claimedStudentIds.includes(student.id)
      );
      return unclaimedStudents;
    },
  },
  methods: {
    getStudentsClaimedByThisParentId() {
      ParentService.getStudentsByParentId(this.parentId).then((response) => {
        this.claimedStudents = response.data;
      });
    },
    getAllStudents() {
      StudentService.getStudentProfiles().then((response) => {
        this.allStudents = response.data;
      });
    },
    getStudents() {
      this.getStudentsClaimedByThisParentId();
      this.getAllStudents();
    },
    addStudent() {
      ParentService.addStudentToParent(this.selectedStudent).then(
        (response) => {
          if (response.status === 201) {
            this.selectedStudent.studentId = "";
            this.selectedStudent.relation = "";
            this.getStudents();
            this.getClaimedStudentIds();
          }
        }
      );
    },
    getClaimedStudentIds() {
      this.claimedStudentIds = [];
      this.claimedStudents.forEach((student) => {
        this.claimedStudentIds.push(student.id);
      });
      return this.claimedStudentIds;
    },
    refreshStudentList() {},
  },
  created() {
    this.getStudents();
  },
};
</script>

<style scoped>
</style>