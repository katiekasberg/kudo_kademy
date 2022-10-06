<template>
  <div>
    <form v-on:submit.prevent="addStudentToClass()">
      <label for="selectedClass">Select Class to Add Students:</label>
      <select
        v-model="classInfo.id"
        id="selectedClass"
        name="selectedClass"
        v-on:change="selectClass()"
      >
        <option
          v-for="classInfo in classes"
          v-bind:key="classInfo.id"
          v-bind:value="classInfo.id"
        >
          {{ classInfo.name }}: {{ classInfo.subject }}- {{ classInfo.period }}
        </option>
      </select>

      <class-detail
        v-bind:classInfoId="parseInt(classInfo.id)"
        v-show="classInfo.id != ''"
      />
      <table>
        <thead>
          <tr>
            <th>&nbsp;</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Graduation Year</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Select Student:</td>
            <td>
              <input
                type="text"
                id="firstNameFilter"
                v-model="filter.firstName"
              />
            </td>
            <td>
              <input
                type="text"
                id="lastNameFilter"
                v-model="filter.lastName"
              />
            </td>
            <td>
              <input type="text" id="emailFilter" v-model="filter.email" />
            </td>
            <td>
              <input
                type="number"
                id="graduationFilter"
                v-model="filter.graduationYear"
              />
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
            <td>{{ student.graduationYear }}</td>
          </tr>
        </tbody>
      </table>
      <button type="submit">Submit</button>
    </form>

    <div v-show="classInfo.id != ''">
      <h3>Current Roster for Selected Class:</h3>
      <table>
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
          </tr>
        </thead>

        <tbody>
          <tr
            v-for="classRosterStudent in classRoster"
            v-bind:key="classRosterStudent.id"
          >
            <td>{{ classRosterStudent.firstName }}</td>
            <td>{{ classRosterStudent.lastName }}</td>
            <td>{{ classRosterStudent.email }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
 
<script>
import teacherService from "../services/TeacherService.js";
import studentService from "../services/StudentService.js";
import classDetail from "../components/ClassDetail.vue";

export default {
  name: "add-student-to-class",
  components: { classDetail },
  data() {
    return {
      classInfoStudent: {
        classId: "",
        studentId: "",
      },
      filter: {
        id: "",
        firstName: "",
        lastName: "",
        email: "",
        graduationYear: "",
      },
      selectedStudentIDs: [],
      rosterIds: [],
      students: [],
      classes: [],
      classRoster: [
        {
          id: "",
          firstName: "",
          lastName: "",
          email: "",
        },
      ],
      classInfo: {
        id: "",
        name: "",
      },
      classInfoId: "",
    };
  },
  methods: {
    getRosterIds() {
      this.rosterIds = [];
      this.classRoster.forEach((studentInRoster) => {
        this.rosterIds.push(studentInRoster.id);
      });
      return this.rosterIds;
    },
    getAvailableStudents() {
      studentService.getStudentProfiles().then((response) => {
        if (response.status === 200) {
          this.students = response.data;
        }
      });
    },
    selectStudents(id) {
      if (this.selectedStudentIDs.includes(id)) {
        this.selectedStudentIDs.splice(this.selectedStudentIDs.indexOf(id), 1);
      } else {
        this.selectedStudentIDs.push(parseInt(id));
      }
    },
    selectClass() {
      this.classInfoStudent.classId = this.classInfo.id;
      this.rosterIds = [];
      this.getClassRoster();
      this.getRosterIds();
    },
    addStudentToClass() {
      this.selectedStudentIDs.forEach((selectedId) => {
        this.classInfoStudent.studentId = selectedId;
        teacherService
          .addStudentToClass(this.classInfoStudent)
          .then((response) => {
            if (response.status === 201) {
              this.classInfoStudent.studentId = "";
              this.getClassRoster();
            }
          });
      });
      this.selectedStudentIDs = [];
    },
    getClassRoster() {
      teacherService.getStudentsInClass(this.classInfo.id).then((response) => {
        if (response.status === 200) {
          this.classRoster = response.data;
        }
      });
    },
  },
  created() {
    teacherService.getOwnClasses().then((response) => {
      if (response.status === 200) {
        this.classes = response.data;
      }
    });
  },
  computed: {
    filteredList() {
      this.getAvailableStudents();
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
      if (this.filter.graduationYear != "") {
        filteredStudents = filteredStudents.filter((student) =>
          student.graduationYear
            .toString()
            .includes(this.filter.graduationYear.toString())
        );
      }
      let currentRoster = this.getRosterIds();
      filteredStudents = filteredStudents.filter(
        (student) => !currentRoster.includes(student.id)
      );
      return filteredStudents;
    },
  },
};
</script>
 
<style scoped>
form {
  background-color: rgba(255, 255, 255, 0.25);
}
</style>