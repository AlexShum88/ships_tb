package com.shum.ships_tb.service.button;

import com.shum.ships_tb.repository.entity.RepoButton;

import java.util.List;

public interface Ibutton {
    RepoButton findByCommand (String command);
    List<RepoButton> findAll ();
}
