<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <td><input type="checkbox" /></td>
          <td>
            <input
              type="text"
              id="firstNameFilter"
              v-model="filter.firstName"
            />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.email" />
          </td>
        </tr>

        <tr v-for="student in filteredList" v-bind:key="student.id">
          <td>
            <input
              type="checkbox"
              v-bind:id="student.id"
              v-bind:value="student.id"
              v-model="selectedStudentIDs"
              v-on:click="selectStudents(student.id)"
            />
          </td>
          <td>{{ student.firstName }}</td>
          <td>{{ student.lastName }}</td>
          <td>{{ student.email }}</td>
        </tr>
      </tbody>
    </table>

    <table>
      <thead>
        <tr>
          <th>Class Name:</th>
          <th>Subject:</th>
          <th>Description:</th>
          <th>Period:</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="classInfo in classes" v-bind:key="classInfo.id">
          <td>{{ classInfo.name }}</td>
          <td>{{ classInfo.subject }}</td>
          <td>{{ classInfo.description }}</td>
          <td>{{ classInfo.period }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
 
<script>
import teacherService from "../services/TeacherService.js";
import studentService from "../services/StudentService.js";

export default {
  name: "add-student-to-class",
  data() {
    return {
      classInfoStudent: {
        classId: Number,
        studentId: Number,
      },
      filter: {
        firstName: "",
        lastName: "",
        email: "",
      },
      selectedStudentIDs: [],
      students: [],
      classes: [],
    };
  },
  methods: {
    selectStudents(id) {
      if (this.selectedStudentIDs.includes(id)) {
        this.selectedStudentIDs.splice(this.selectedStudentIDs.indexOf(id), 1);
      } else {
        this.selectedStudentIDs.push(parseInt(id));
      }
    },
    selectClass() {
      return 0;
    },
    addStudentToClass() {
      teacherService
        .addStudentToClass(this.classInfoStudent)
        .then((response) => {
          if (response.status === 201) {
            this.classInfoStudent.studentId = "";
          }
        });
    },
  },
  created() {
    studentService.getStudentProfiles().then((response) => {
      this.students = response.data;
    });
      teacherService.getOwnClasses().then((response) => {
          this.classes = response.data;
  });
  },
  computed: {
    filteredList() {
      let filteredStudents = this.students;
      if (this.filter.firstName != "") {
        filteredStudents = filteredStudents.filter((student) =>
          student.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredStudents = filteredStudents.filter((student) =>
          student.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.email != "") {
        filteredStudents = filteredStudents.filter((student) =>
          student.email.toLowerCase().includes(this.filter.email.toLowerCase())
        );
      }
      return filteredStudents;
    },
  },
};
</script>
 
<style>
</style>
