package com.example.gymdiary.Utils;

        import android.content.Context;
        import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
        import android.widget.*;
        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;
import com.example.gymdiary.R;
import com.example.gymdiary.Workout;
import com.example.gymdiary.Workout_summary;
        import org.jetbrains.annotations.NotNull;

        import java.util.List;

        public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder> {

            private List<Workout> workoutList;
                private Workout_summary workout_summary;


                public WorkoutAdapter(Workout_summary workout_summary){
                this.workout_summary = workout_summary;

            }

                public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout,parent,false);
                return new ViewHolder(itemView);

            }

            @Override
            public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

                    Workout workout = workoutList.get(position);
                    holder.rep.setText(Integer.toString(workout.getRep()));
                    holder.série.setText(Integer.toString(workout.getSerie()));
                    holder.poid.setText(Integer.toString(workout.getPoid()));

            }

            @Override
            public int getItemCount() {
                return workoutList.size();
            }

            public void setWorkout(List<Workout> workoutList){
                    this.workoutList = workoutList;
                    notifyDataSetChanged();


            }
            public Context getContext(){return this.workout_summary;}

            public void deleteitem(int position){
                    Workout item = workoutList.get(position);
                    workoutList.remove(position);
                    notifyItemRemoved(position);

            }

            public static class ViewHolder extends RecyclerView.ViewHolder{
                        EditText rep,série,poid;
                        Spinner machine;

                        ViewHolder(View view){
                        super(view);
                        machine = view.findViewById(R.id.machinetxt);
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.machines, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        machine.setAdapter(adapter);
                        machine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                        rep = view.findViewById(R.id.reps);
                        série = view.findViewById(R.id.série);
                        poid = view.findViewById(R.id.poid);

                            }
            }

            }
