package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Level;
import com.crio.codingame.services.IContestService;

public class ListContestCommand implements ICommand{

    private final IContestService contestService;
    
    public ListContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllContestLevelWise method of IContestService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_CONTEST","HIGH"]
    // or
    // ["LIST_CONTEST"]

    @Override
    public void execute(List<String> tokens) {
        Level l=Level.LOW;
        if(tokens.size()==1)
        System.out.println(contestService.getAllContestLevelWise(null));
        else
        {
        if(tokens.get(1).equalsIgnoreCase("medium"))
        l=Level.MEDIUM;
        if(tokens.get(1).equalsIgnoreCase("high"))
        l=Level.HIGH;
        
        System.out.println(contestService.getAllContestLevelWise(l));
        }
    }
    
}
