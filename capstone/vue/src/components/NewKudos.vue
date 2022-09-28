<template>
  <div>
    <h1>SCHOOL COMMUNICATION</h1>
    <img class="logo" src="../../resources/school-icon-9.png" alt="" />

    <h2 class="h3 mb-3 font-weight-normal">Send A Kudo!</h2>

    <form v-on:submit.prevent action="submit">
      <label for="StudentId">Student Id:</label><br />
      <input
        v-model="kudo.studentId"
        type="text"
        id="StudentId"
        name="StudentId"
      />
      <label for="kudoType" class="sr-only"
        >Kudo Type:

        <select v-model="kudo.typeId" name="kudo-type" id="kudo-type">
          <option
            v-for="kudoType in this.$store.state.kudoTypes"
            v-bind:key="kudoType.id"
            v-bind:value="kudoType.id"
          >
            {{ kudoType.name }} Points: {{ kudoType.value }}
          </option>
        </select>
      </label>

      <label for="Comments">Comments:</label><br />
      <input
        v-model="kudo.message"
        type="text"
        id="Comments"
        name="Comments"
      /><br />
      <button type="submit" v-on:click="saveKudo()">Send</button>
    </form>
  </div>
</template>

  <script>
import kudoService from "../services/KudosService";
export default {
  data() {
    return {
      kudo: {
        studentId: "",
        typeId: "",
        message: "",
      },
    };
  },
  methods: {
    saveKudo() {
      kudoService.SendKudos(this.kudo).then((response) => {
        if (response.status === 200) {
          this.kudo.studentId = "";
          this.kudo.typeId = false;
          this.kudo.message = "";
        }
      });
    },
    getKudoTypes() {
      kudoService.getKudoTypes().then((response) => {
        // if (response.status === 200) {
        this.$store.commit("SET_KUDO_TYPES", response.data);
      });
    },
  },
  created() {
    this.getKudoTypes();
  },
};
</script>
    <style scoped>
.send-kudo {
  display: grid;
  align-items: center;
  justify-content: center;
  grid-gap: 7px;
}
img.logo {
  margin: auto;
  display: block;
  width: 200px;
  height: auto;
}
h1 {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
}
h2 {
  display: grid;
  grid-area: left;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
}
form {
  display: grid;
  grid-area: auto;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  margin: 10px;
}
label {
  float: left;
  clear: none;
  display: block;
  padding: 0px 0em 0px 20px;
}

input[type="radio"],
input.radio {
  float: left;
  clear: none;
  margin: 0px 200px 0px 0px;
}
</style>
  
