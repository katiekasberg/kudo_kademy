<template>
  <div>
    <form v-on:submit.prevent action="submit" class="newClassForm"></form>
    <p>Create a new Class</p>
    <label for="ClassName">
      Class Name:
      <input type="text" v-model="newClass.name" />
    </label>
    <label for="Subject">
      Subject:
      <input type="text" v-model="newClass.subject" />
    </label>
    <label for="teacherId">
      Teacher:
      <input type="number" v-model="newClass.teacherId" />
    </label>
    <label for="schoolId">
      School:
      <input type="number" v-model="newClass.schoolId" />
    </label>
    <label for="description">
      Description:
      <input type="text" v-model="newClass.description" />
    </label>
    <label for="period">
      Period:
      <input type="text" v-model="newClass.period" />
    </label>
    <label for="startTime">
      Start Time:
      <input type="time" step="2" v-model="newClass.startTime" />
    </label>
    <label for="endTime">
      End Time:
      <input type="time" step="2" v-model="newClass.endTime" />
    </label>
    <label for="schoolYear">
      School Year:
      <input type="number" value="2022" v-model="newClass.schoolYear" />
    </label>
    <button type="submit" v-on:click="saveClass()">Submit</button>
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

<style scoped>
</style>