<template>
  <div>
    <form v-on:submit.prevent action="submit" class="newClassForm">
      <p>Create a New Class</p>
      <label for="ClassName"> Class Name:</label>
      <input type="text" v-model="newClass.name" />

      <label for="Subject"> Subject:</label>
      <input type="text" v-model="newClass.subject" />

      <label for="teacherId"> Teacher:</label>
      <input type="number" v-model="newClass.teacherId" />

      <label for="schoolId"> School:</label>
      <input type="number" v-model="newClass.schoolId" />

      <label for="description"> Description: </label>
      <input type="text" v-model="newClass.description" />

      <label for="period"> Period: </label>
      <input type="text" v-model="newClass.period" />

      <label for="startTime"> Start Time: </label>
      <input type="time" step="2" v-model="newClass.startTime" />

      <label for="endTime"> End Time: </label>
      <input type="time" step="2" v-model="newClass.endTime" />

      <label for="schoolYear"> School Year: </label>
      <input type="number" value="2022" v-model="newClass.schoolYear" />

      <button type="submit" v-on:click="saveClass()">Submit</button>
    </form>
  </div>
</template>

<script>
import TeacherService from "../services/TeacherService";
export default {
  data() {
    return {
      newClass: {
        name: "",
        subject: "",
        teacherId: this.$store.state.user.id,
        schoolId: 0,
        description: "",
        period: "",
        startTime: "",
        endTime: "",
        schoolYear: 2022,
      },
    };
  },
  methods: {
    saveClass() {
      TeacherService.addNewClass(this.newClass).then((response) => {
        if (response.status === 201) {
          this.newClass.name = "";
          this.newClass.subject = "";
          this.newClass.teacherId = 0;
          this.newClass.schoolId = 0;
          this.newClass.description = "";
          this.newClass.period = "";
          this.newClass.startTime = "";
          this.newClass.endTime = "";
          this.newClass.schoolYear = 2022;
        }
      });
    },
  },
};
</script>

<style>
.newClassForm {
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
}

label {
  padding-top: 10px;
  font-weight: bold;
}
p {
  display: grid;
  font-size: x-large;
  align-content: center;
  justify-content: center;
}
button {
  margin: 20px;
  padding: 10px;
  border-radius: 5px;
}
</style>