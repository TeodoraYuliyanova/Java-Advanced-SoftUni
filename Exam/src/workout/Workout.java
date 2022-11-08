package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public String getType() {
        return type;
    }


    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }


    public boolean removeExercise(String name, String muscle) {
        return this.exercises.removeIf(e -> e.getName().equals(name) && e.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }


    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s", getType()));
        sb.append(System.lineSeparator());

        for (Exercise exercise : this.exercises) {
            sb.append(exercise.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
