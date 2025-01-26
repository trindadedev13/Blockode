package dev.trindadedev.blockode.ui.dialogs;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import dev.trindadedev.blockode.R;
import dev.trindadedev.blockode.beans.ProjectBasicInfoBean;
import dev.trindadedev.blockode.beans.ProjectBean;
import dev.trindadedev.blockode.databinding.DialogCreateProjectBinding;
import dev.trindadedev.blockode.project.ProjectManager;


public class createProjectDialog extends BottomSheetDialog {
    private final DialogCreateProjectBinding binding;

    public createProjectDialog(@NonNull Context context) {
        super(context);
        binding = DialogCreateProjectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void show() {
        super.show();
        binding.save.setOnClickListener(v -> {
            var project = new ProjectBean();
            var basicInfo = new ProjectBasicInfoBean();
            basicInfo.name = Objects.requireNonNull(binding.projectName.getText()).toString();
            basicInfo.packageName = Objects.requireNonNull(binding.projectPackage.getText()).toString();
            basicInfo.mainClassPackage = basicInfo.packageName + "." + Objects.requireNonNull(binding.projectClass.getText());
            project.scId = String.valueOf(UUID.randomUUID()); //random scid for now
            project.basicInfo = basicInfo;
            project.variables = new ArrayList<>();

            if (!basicInfo.packageName.isBlank() && !basicInfo.packageName.isBlank() && !basicInfo.mainClassPackage.isBlank()) {
                ProjectManager.createProjectByBean(project);
                dismiss();
            } else {
                Toast.makeText(getContext(), R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
            }
        });

        binding.cancel.setOnClickListener(v -> {
            dismiss();
        });

    }
}
