<script setup lang="ts">
import { ref, useTemplateRef } from 'vue'
import axios from 'axios'
import IdeaPairsDisplay from './IdeaPairsDisplay.vue'

interface submitTarget extends EventTarget{
  word: {value: string},
  amount: {value:number}
}
const ideas = ref([]);
const word = ref("");
const wordInput = useTemplateRef("wordInput");
const amountInput = useTemplateRef("amountInput");
const getNumber = async (amount:number) => {
  try {
    const response = await axios.get(`http://127.0.0.1:8080/${amount}`)
    ideas.value = response.data
  } catch (error) {
    console.log(error)
  }
}
const onSubmit = (e:Event) => {
  const submitTarget = e.target as submitTarget;
  word.value = submitTarget.word.value;
  getNumber(submitTarget.amount.value);
}
const onClickReset = (e:Event) => {
  word.value = "";
  ideas.value = [];
}
</script>
<template>
  <form v-if="ideas.length<=0" @submit.prevent="onSubmit" class="PairsForm">
    <section class="PairsForm-Section">
      <label class="PairsForm-Label">Your Word</label>
      <input type="text" name="word" class="PairsForm-Input-Word" required ref="wordInput"/>
    </section>
    <section class="PairsForm-Section">
      <label class="PairsForm-Label">Ideas</label>
      <input type="text" name="amount" class="PairsForm-Input-Number" label="Amount Per Group" required ref="amountInput"/>
    </section>
    <button type="submit" class="PairsForm-Button">Ready!</button>
  </form>
  <section v-if="ideas.length>0">
    <IdeaPairsDisplay :word=word :ideas=ideas />
    <button class="PairsForm-Button" @click.prevent="onClickReset">Reset</button>
  </section>
</template>
<style>
.PairsForm {
  background-color: var(--orange);
  padding: 16px 10%;
  font-family: yokelvision-font;
  font-size: 32px;
  display: flex;
  flex-direction: column;
  width: 100%;
  align-items: flex-start;
  justify-content: flex-end;
}
.PairsForm-Section {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-right: 32px;
  @media only screen and (min-width: 1024px) {
    align-items: flex-end;
    width: 100%;
  }
}
.PairsForm-Label {
  color: var(--blue);
  font-size: 48px;
  text-align: right;
  text-wrap: nowrap;
}
.PairsForm-Input-Word {
  margin-right: 12px;
  background-color: var(--blue);
  color: var(--orange);
  font-size: 32px;
  padding: 16px 16px 16px 32px;
  border: none;
  width: 100%;
  border-radius: 128px 256px;
}
.PairsForm-Input-Number {
  margin-right: 12px;
  background-color: var(--blue);
  color: var(--orange);
  font-size: 32px;
  padding: 16px 16px 16px 32px;
  border: none;
  width: 85px;
  border-radius: 128px 256px;
}
.PairsForm-Button {
  background-color: var(--orange);
  color: var(--blue);
  border: none;
  font-size: 64px;
  font-weight: 900;
  height: 100%;
  padding-bottom: 0px;
  width: 100%;
  font-family: yokelvision-font;
  border-radius: 28px;
  margin-top: 16px;
}
.PairsForm-Button:hover {
  color: var(--orange);
  background-color: var(--blue);
  border-radius: 128px 256px;
  font-family: laff-riot-nf-font;
}
.PairsForm-Button:active {
  background-color: var(--orange) !important;
  color: var(--blue) !important;
  border-radius: 128px 256px;
  font-family: laff-riot-nf-font;
}
</style>
